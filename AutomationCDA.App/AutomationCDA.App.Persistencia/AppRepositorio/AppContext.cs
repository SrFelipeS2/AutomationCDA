using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;
using AutomationCDA.App.Dominio;

#nullable disable

namespace AutomationCDA.App.Persistencia
{
    public partial class AppContext : DbContext
    {
        public AppContext()
        {
        }

        public AppContext(DbContextOptions<AppContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Persona> Personas { get; set; }
        public virtual DbSet<Repuesto> Repuestos { get; set; }
        public virtual DbSet<RepuestoRevision> RepuestoRevisiones { get; set; }
        public virtual DbSet<Revision> Revisiones { get; set; }
        public virtual DbSet<Rol> Roles { get; set; }
        public virtual DbSet<SeguroAdicional> SeguroAdicionales { get; set; }
        public virtual DbSet<Usuario> Usuarios { get; set; }
        public virtual DbSet<UsuarioVehiculo> UsuarioVehiculos { get; set; }
        public virtual DbSet<Vehiculo> Vehiculos { get; set; }
        public virtual DbSet<VehiculoSeguroAdicional> VehiculoSeguroAdicionales { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see http://go.microsoft.com/fwlink/?LinkId=723263.
                optionsBuilder.UseSqlServer("Server=DESKTOP-6KVRPV0; Database=AutomationCDA; Integrated Security=True;");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Persona>(entity =>
            {
                entity.ToTable("Persona");

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Apellidos)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("apellidos");

                entity.Property(e => e.Cedula)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("cedula");

                entity.Property(e => e.CorreoElectronico)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("correoElectronico");

                entity.Property(e => e.Direccion)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("direccion");

                entity.Property(e => e.NivelEstudios)
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("nivelEstudios");

                entity.Property(e => e.Nombre)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("nombre");

                entity.Property(e => e.Telefono)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("telefono");
            });

            modelBuilder.Entity<Repuesto>(entity =>
            {
                entity.ToTable("Repuesto");

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.CantidadRepuesto).HasColumnName("cantidadRepuesto");

                entity.Property(e => e.Descripcion)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("descripcion");

                entity.Property(e => e.ValorRepuesto).HasColumnName("valorRepuesto");
            });

            modelBuilder.Entity<RepuestoRevision>(entity =>
            {
                entity.HasNoKey();

                entity.ToTable("Repuesto_Revision");

                entity.Property(e => e.IdRepuesto).HasColumnName("idRepuesto");

                entity.Property(e => e.IdRevision).HasColumnName("idRevision");

                entity.HasOne(d => d.IdRepuestoNavigation)
                    .WithMany()
                    .HasForeignKey(d => d.IdRepuesto)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_Repuestos_Revisiones_Repuestos");

                entity.HasOne(d => d.IdRevisionNavigation)
                    .WithMany()
                    .HasForeignKey(d => d.IdRevision)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_Repuestos_Revisiones_Revisiones");
            });

            modelBuilder.Entity<Revision>(entity =>
            {
                entity.ToTable("Revision");

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.FechaRevision)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("fechaRevision");

                entity.Property(e => e.IdVehiculo).HasColumnName("idVehiculo");

                entity.Property(e => e.NivelAceite)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("nivelAceite");

                entity.Property(e => e.NivelDireccion)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("nivelDireccion");

                entity.Property(e => e.NivelFrenos)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("nivelFrenos");

                entity.Property(e => e.NivelRefrigerante)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("nivelRefrigerante");

                entity.HasOne(d => d.IdVehiculoNavigation)
                    .WithMany(p => p.Revisiones)
                    .HasForeignKey(d => d.IdVehiculo)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_Revisiones_Vehiculos");
            });

            modelBuilder.Entity<Rol>(entity =>
            {
                entity.ToTable("Rol");

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.TipoUsuario)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("tipoUsuario");
            });

            modelBuilder.Entity<SeguroAdicional>(entity =>
            {
                entity.ToTable("SeguroAdicional");

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.FechaVencimiento)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("fechaVencimiento");

                entity.Property(e => e.TipoSeguro)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("tipoSeguro");
            });

            modelBuilder.Entity<Usuario>(entity =>
            {
                entity.ToTable("Usuario");

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Contraseña)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("contraseña");

                entity.Property(e => e.IdPersona).HasColumnName("idPersona");

                entity.Property(e => e.IdRol).HasColumnName("idRol");

                entity.Property(e => e.NombreUsuario)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("nombreUsuario");

                entity.HasOne(d => d.IdPersonaNavigation)
                    .WithMany(p => p.Usuarios)
                    .HasForeignKey(d => d.IdPersona)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_Usuarios_Personas1");

                entity.HasOne(d => d.IdRolNavigation)
                    .WithMany(p => p.Usuarios)
                    .HasForeignKey(d => d.IdRol)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_Usuarios_Roles");
            });

            modelBuilder.Entity<UsuarioVehiculo>(entity =>
            {
                entity.HasNoKey();

                entity.ToTable("Usuario_Vehiculo");

                entity.Property(e => e.IdUsuario).HasColumnName("idUsuario");

                entity.Property(e => e.IdVehiculo).HasColumnName("idVehiculo");

                entity.HasOne(d => d.IdUsuarioNavigation)
                    .WithMany()
                    .HasForeignKey(d => d.IdUsuario)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_Usuarios_Vehiculos_Usuarios");

                entity.HasOne(d => d.IdVehiculoNavigation)
                    .WithMany()
                    .HasForeignKey(d => d.IdVehiculo)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_Usuarios_Vehiculos_Vehiculos");
            });

            modelBuilder.Entity<Vehiculo>(entity =>
            {
                entity.ToTable("Vehiculo");

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.CapacidadPasajeros).HasColumnName("capacidadPasajeros");

                entity.Property(e => e.CilindradaMotor)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("cilindradaMotor");

                entity.Property(e => e.EstadoSoat)
                    .IsRequired()
                    .HasMaxLength(10)
                    .IsUnicode(false)
                    .HasColumnName("estadoSoat");

                entity.Property(e => e.Marca)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("marca");

                entity.Property(e => e.Modelo)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("modelo");

                entity.Property(e => e.Observaciones)
                    .HasMaxLength(200)
                    .IsUnicode(false)
                    .HasColumnName("observaciones");

                entity.Property(e => e.Placa)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("placa");

                entity.Property(e => e.TipoVehiculo)
                    .IsRequired()
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("tipoVehiculo");
            });

            modelBuilder.Entity<VehiculoSeguroAdicional>(entity =>
            {
                entity.HasNoKey();

                entity.ToTable("Vehiculo_SeguroAdicional");

                entity.Property(e => e.IdSeguro).HasColumnName("idSeguro");

                entity.Property(e => e.IdVehiculo).HasColumnName("idVehiculo");

                entity.HasOne(d => d.IdSeguroNavigation)
                    .WithMany()
                    .HasForeignKey(d => d.IdSeguro)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_Vehiculos_SegurosAdicionales_SegurosAdicionales");

                entity.HasOne(d => d.IdVehiculoNavigation)
                    .WithMany()
                    .HasForeignKey(d => d.IdVehiculo)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_Vehiculos_SegurosAdicionales_Vehiculos");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
